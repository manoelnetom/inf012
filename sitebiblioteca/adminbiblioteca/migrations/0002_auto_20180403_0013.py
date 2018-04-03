# Generated by Django 2.0.3 on 2018-04-03 00:13

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('adminbiblioteca', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Livro',
            fields=[
                ('codigo', models.AutoField(primary_key=True, serialize=False)),
                ('titulo', models.CharField(max_length=200)),
                ('autor', models.CharField(max_length=200)),
            ],
        ),
        migrations.CreateModel(
            name='Sessao',
            fields=[
                ('codigo', models.AutoField(primary_key=True, serialize=False)),
                ('descricao', models.CharField(max_length=200)),
                ('localizacao', models.CharField(max_length=200)),
            ],
        ),
        migrations.AddField(
            model_name='livro',
            name='sessao',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='adminbiblioteca.Sessao'),
        ),
    ]