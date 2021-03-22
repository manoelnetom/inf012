from django import forms
from django.contrib.auth.forms import UserCreationForm, UserChangeForm
from .models import Usuario

class CustomUserCreationForm(UserCreationForm):
	
	class Meta(UserCreationForm):
		 model = Usuario
		 fields=('email',)

class CustomUserChangeForm(UserChangeForm):

	class Meta(UserCreationForm):
		 model = Usuario
		 fields=('email',)
