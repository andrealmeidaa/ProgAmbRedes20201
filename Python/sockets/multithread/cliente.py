import socket

host='127.0.0.1' #Endereço do servidor
port=2345 #Porta do servidor

cliSocket=socket.socket()
cliSocket.connect((host,port)) #Realiza a conexão com o servidor

mensagem=input("->") #Solicita a leitura de dados a partir do terminal
while mensagem!='q': #Enquanto não for digitado q
    cliSocket.send(mensagem.encode()) #Envia a string encodada em bytes
    dados=cliSocket.recv(1024).decode() #Recebe 1024 bytes do servidor e realiza o decode
    print("Resposta Recebida do Servidor: "+dados)
    mensagem=input("->") #Continua a leitura
cliSocket.close()