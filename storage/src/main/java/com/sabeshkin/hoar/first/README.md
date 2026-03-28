# Тройки Хоара

## max
``` 
{P: x>y}  max(x, y) {Q: res=x}  
{P: x==y} max(x, y) {Q: res=err}
``` 
## abs
``` 
{P: -x} abs(x) {Q: res=x}  
{P: x}  abs(x) {Q: res=x}
``` 
## maxAbs
``` 
{P: abs(x)>abs(y)}   maxAbs(x, y) {Q: res=abs(x)}  
{P: abs(x)==abs(y)}  maxAbs(x, y) {Q: res=err}
```