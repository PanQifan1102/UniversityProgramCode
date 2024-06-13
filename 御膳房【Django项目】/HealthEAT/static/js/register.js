$(function(){
   function bindCaptchaBtnClick(){
       $("#captcha-btn").click(function (event){
       let $this = $(this)
       let email = $("input[name='email']").val();
       if(!email){
           alert("邮箱格式错误（email error）:<");
           return;
       }
       //取消按钮点击
       $this.off('click');

       //发送请求
       $.ajax('/auth/captcha?email='+email,{
           method:'GET',
           success:function (result){
               if(result['code']==200){
                   alert("验证码发送成功（The verification code is sent successfully）");
               }else{
                   alert(result['message']);
               }
           },
           fail:function(error){
               console.log(error);
           }
       })
       //倒计时
       let countdown = 10;
       let timer = setInterval(function(){
           if(countdown<=0){
               $this.text('获取验证码（Get Captcha）');
               //取消定时器
               clearInterval(timer);
               //重置绑定事件
               bindCaptchaBtnClick();
           }else{
               $this.text(countdown+"s")
               countdown--;
           }
       },1000)
    })
   }
   bindCaptchaBtnClick();
});