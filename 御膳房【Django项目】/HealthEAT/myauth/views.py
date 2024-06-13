from django.shortcuts import render, redirect, reverse
from django.http.response import JsonResponse
import string
import random
from django.core.mail import send_mail
from .models import CaptchaModel
from django.views.decorators.http import require_http_methods
from .forms import RegisterForm, LoginForm
from django.contrib.auth import get_user_model, login, logout
from django.contrib.auth.models import User


User = get_user_model()


@require_http_methods(['GET', 'POST'])
# 登录
def mylogin(request):
    if request.method == 'GET':
        return render(request, 'login.html')
    else:
        form = LoginForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data.get('email')
            password = form.cleaned_data.get('password')
            remember = form.cleaned_data.get('remember')
            user = User.objects.filter(email=email).first()
            if user and user.check_password(password):
                login(request, user)  # 登录
                user.is_authenticated  # 判断用户登录状态
                if not remember:  # 判断是否点击了记住我
                    request.session.set_expiry(0)
                return redirect('/')
            else:
                print('邮箱或密码错误:<')
                # form.add_error('email', '邮箱或密码错误:<')
                # return render(request, 'login.html', context={'form': form})
                return redirect(reverse('myauth:login'))


def mylogout(request):
    logout(request)
    return redirect('/')


@require_http_methods(['GET', 'POST'])
# 注册
def register(request):
    if request.method == 'GET':
        return render(request, 'register.html')
    else:
        form = RegisterForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data.get('email')
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            User.objects.create_user(username=username, email=email, password=password)
            return redirect(reverse('myauth:login'))
        else:
            print(form.errors)
            return redirect(reverse('myauth:register'))


# 发送邮箱验证码
def send_email_captcha(request):
    email = request.GET.get('email')
    if not email:
        return JsonResponse({"code": 400, "message": "邮箱格式错误！"})
    # 验证码为4位随机阿拉伯数字
    captcha = "".join(random.sample(string.digits, 4))
    CaptchaModel.objects.update_or_create(email=email, defaults={"captcha": captcha})  # 查找或验证邮箱验证码
    send_mail("御膳房验证码（Imperial Dining Room Registration Verification Code）",
              message=f"你的注册验证码是（Your registration verification code is）：{captcha}", recipient_list=[email], from_email=None)
    return JsonResponse({"code": 200, "message": "验证码发送成功（Success） :>"})
