
#from django.contrib.auth.models import AbstractUser
from django.db import models

class Usuario(models.Model):
	matricula = models.CharField(max_length=200, primary_key=True)
	nome =models.CharField(max_length=100)
	endereco =  models.TextField()
	telefone =  models.CharField(max_length=80)
