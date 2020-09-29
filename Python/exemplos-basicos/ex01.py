class Complexo(object):
    def __init__(self,real,imaginario):
        self.__real=real
        self._imaginario=imaginario
c1=Complexo(2,3)
print(c1.__real)