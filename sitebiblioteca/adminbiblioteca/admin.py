from django.contrib import admin
from .models import Usuario, Livro, Emprestimo, Sessao
# Register your models here.

admin.site.register(Usuario)
admin.site.register(Livro)
admin.site.register(Emprestimo)
admin.site.register(Sessao)