from django import forms


# 发布日记
class PubBlogForm(forms.Form):
    title = forms.CharField(max_length=100, min_length=2)
    content = forms.CharField(min_length=2)
    category = forms.IntegerField()
