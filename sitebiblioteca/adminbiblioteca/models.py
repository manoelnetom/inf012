from django.db import models
from django.utils import timezone
# Create your models here.

class Usuario(models.Model):
    login = models.ForeignKey('auth.User', on_delete=models.CASCADE)
    matricula = models.CharField(max_length=15)
    nome = models.CharField(max_length=200)
    email = models.CharField(max_length=200)
    endereco = models.TextField()
    telefone = models.CharField(max_length=15)

    def __str__(self):
        return self.nome

class Sessao(models.Model):
    codigo = models.AutoField(primary_key=True)
    descricao = models.CharField(max_length=200)
    localizacao = models.CharField(max_length=200)

    def __str__(self):
        return self.descricao

class Livro(models.Model):
    codigo = models.AutoField(primary_key=True)
    titulo = models.CharField(max_length=200)
    autor = models.CharField(max_length=200)
    sessao = models.ForeignKey(Sessao, on_delete=models.CASCADE)

    def __str__(self):
        return self.titulo

class Emprestimo(models.Model):
    codigo = models.AutoField(primary_key=True)
    datahora = models.DateTimeField(
        default=timezone.now,verbose_name="Data e Hora")
    usuario = models.ForeignKey(Usuario,  on_delete=models.CASCADE)
    devolucao = models.DateTimeField(
        default=timezone.now, verbose_name="Devolucao")
    livros = models.ManyToManyField(Livro)

    def __str__(self):
        return self.codigo


