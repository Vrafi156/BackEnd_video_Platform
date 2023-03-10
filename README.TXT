Pentru etapa1 am creat initial clasele mele de input pentru a putea
citi din fisierele JSON pentru Input. Crearea acestor clase pentru Input
este asemanatoare cu cea din Tema1 GwentStone. Dupa realizarea claselor
de input care contineau campurile din fisierele json
am inceput implementarea propriu zisa a temei.

Pentru Inceput am decis sa implementez structura de netflix folosindu-ma
de 2 hashmap-uri de tipul String si Arraylsit<String> pentru a retine
"copiii" si "copiii functiilor" pentru pagini. Aceste hashmap-uri sunt
folosite pentru a naviga in structura si a verifica anumite ERRORI

Am folosit pagina Movies pentru a extinde clasa de moviesInput pentru ai
putea seta toti parametrii necesari. Dupa asta am clonat lista de filme din Input
intr-un arraylist de tipul Movies(clasa care extinde moviesInput) pentru a
lucra mai usor cu ele. Tot asemanator am extins si clasa de userInput in Currusr
pentru a retine noile campuri necesare si la fel am facut o copie a bazei de date
de user de tipul userInput.

Pentru inceput am facut un parser de comenzi si in functie de ce comanda primeam
verificam daca se poate realiza sau daca returneaza eroare
Pentru afisarea de erori am facut o clasa de tipul Output(care cotine parametrii necesari
afisarii un arraylist de curent movies , unui user si al unui mesej de eroare.
Pentru login verific daca utilizatorul se afla in baza de date, daca da se logheaza
cu succes si este trimis pe pagina cu homepageAUTH daca nu se intoarce pe homepageNeauth
Cazul de register asemanator numai ca se verifica daca user-ul nu exista in cazul
in care acesta nu exista, se adaga un database.Pentru fiecare operatie de succes sau failed
se returneaza output-ul corespunzator.
Pentru change page pe Movies se copiaza tot database-ul de filme in lista curenta
a unui user pentru a fi prelucrat mai tarziu. Pentru see details, pastram in current
movielist doar filmele pe care le cautam. Pentru functiile de purchase like , rate,
si watch am verificat conditia de "ierarhie" (daca filmul vazut este cumparat , daca am vazut
filmul ca sa-i dau like etc.). Functiile acestea le-am implementat in clasa de Page.
Pentru filters am facut sortari sau eliminari din lista curenta de filme dupa fiecare caz.
Sortarile au fost realizate cu ajutorul functiilor lambda. Pentru a tine minte userul curent
cu lista lui de filme, ma folosescs de clasa dates.Pentru funtia de search cauta un film al
carui titlu incepe cu un anumit string.

Pentru singletonn patern m-am decis sa folosesc singlettonPatter pentru clasa de dates
ca sa nu o instantiez de mai multe ori.


Pentru Output-uri am facut deepcopy ca sa afisez starea clasei la momentul actual.