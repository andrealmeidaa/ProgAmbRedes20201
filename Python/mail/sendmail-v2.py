import yagmail,configparser
import json
config = configparser.ConfigParser()
config.read("conf")#Realizar leitura das configurações de acesso
sender=yagmail.SMTP(config['Mail']['username'],
config['Mail']['password'])
with open('emails.json') as arquivo_json:
        contatos=json.load(arquivo_json)

conteudo="""\
<html>
    <body>
        <p> Ola {nome}!</p>
        <p> Aprenda mais sobre Python em  <a href="https://www.tutorialspoint.com/python/index.htm">TutorialPythons</a></p>
    </body>
</html>
"""

assunto='Notificação Tutorial'
i=0
for contato in contatos:
       i=i+1
       print("Enviando mensagem {0} de {1}".format(i,len(contatos)))
       sender.send(to=contato['email'],subject=assunto,
       contents=conteudo.format(nome=contato['nome']), attachments='arquivo.pdf')
       print("Mensagem enviada para {0}".format(contato['nome']))




#sender.send(to=destinatario,subject=assunto,contents=conteudo)

print("Concluido o Envio")

