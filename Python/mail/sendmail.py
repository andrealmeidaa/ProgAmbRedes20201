import yagmail,configparser
config = configparser.ConfigParser()
config.read("conf")#Realizar leitura das configurações de acesso
sender=yagmail.SMTP(config['Mail']['username'],config['Mail']['password'])

destinatario=['andregustavoo@gmail.com','andre.almeida@escolar.ifrn.edu.br']
assunto='Teste de Mensagem'
conteudo="""\
<html>
    <body>
        <p> Este é uma mensagem importante</p>
        <p> Clique no <a href="http://www.google.com">Google</a></p>
    </body>
</html>
"""
sender.send(to=destinatario,subject=assunto,contents=conteudo)


