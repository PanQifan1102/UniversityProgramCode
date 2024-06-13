from django.db import models
from django.contrib.auth import get_user_model

User = get_user_model()


# 日记的类型
class BlogCategory(models.Model):
    name = models.CharField(max_length=200, verbose_name='类型名称')

    def __str__(self):
        return self.name

    class Meta:
        verbose_name = '日记类型'
        verbose_name_plural = '日记类型'


# 日记的内容
class Blog(models.Model):
    title = models.CharField(max_length=200, verbose_name='日记标题')
    content = models.TextField( verbose_name='日记内容')
    pub_time = models.DateTimeField(auto_now_add=True,  verbose_name='发布时间')
    category = models.ForeignKey(BlogCategory, on_delete=models.CASCADE,  verbose_name='日记类型')
    author = models.ForeignKey(User, on_delete=models.CASCADE,  verbose_name='日记作者')

    def __str__(self):
        return self.title

    class Meta:
        verbose_name = '日记内容'
        verbose_name_plural = '日记内容'
        ordering = ['-pub_time']


# 日记评论
class BlogComment(models.Model):
    content = models.TextField(verbose_name='评论内容')
    pub_time = models.DateTimeField(auto_now_add=True, verbose_name='发布时间')
    blog = models.ForeignKey(Blog, on_delete=models.CASCADE, related_name='comments', verbose_name='所属日记')
    author = models.ForeignKey(User, on_delete=models.CASCADE, verbose_name='评论作者')

    def __str__(self):
        return self.content

    class Meta:
        verbose_name = '日记评论'
        verbose_name_plural = '日记评论'
        ordering = ['-pub_time']
