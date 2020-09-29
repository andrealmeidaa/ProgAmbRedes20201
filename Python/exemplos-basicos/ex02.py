import abc
class FiguraGeometrica(metaclass=abc.ABCMeta):
    @abc.abstractclassmethod
    def area(self):
        pass
class Quadrado(FiguraGeometrica):
    def __init__(self,lado):
        self.lado=lado
    def area(self):
        return self.lado**2
class Retangulo(FiguraGeometrica):
    def __init__(self,base,altura):
        self.base=base
        self.altura=altura
    def area(self):
        return self.base*self.altura

#fig=FiguraGeometrica() #erro - Classe abstrata

quadrado=Quadrado(4)
print(str(quadrado.area()))
retangulo=Retangulo(2,3)
print(str(retangulo.area()))