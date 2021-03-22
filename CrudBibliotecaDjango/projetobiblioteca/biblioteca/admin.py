from django.contrib import admin
from django.contrib.auth.admin import UserAdmin

from .models import Usuario
from .forms import CustomUserCreationForm, CustomUserChangeForm


class CustomUserAdmin(UserAdmin):
	add_form = CustomUserCreationForm
	form = CustomUserChangeForm
	model = Usuario
	list_display = ('email', 'is_staff', 'is_active',)
	list_filter = ('email', 'is_staff', 'is_active',)
	fieldsets = ((None, {'fields': ('email', 'password')}),('Permissions', {'fields': ('is_staff', 'is_active')}),)
	search_fields = ('email',)
	ordering = ('email',)

admin.site.register(Usuario, CustomUserAdmin)
# Register your models here.
