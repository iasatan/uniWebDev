Beadandó

Modulos Spring Web Szerver
Minimum 5 modul
-Web
-Controller
-Service
-Persist
-Model

Kezelje le a következő URL-eket az adott viselkedéssel:
/books: visszatér egy JSON dokumentummal, amiben benne van az összes adatbázisban tárolt könyv
Lehet inmemery adatbázis, plusz pont a kiadott JSON fájl használata, extra plusz pont adatbáziskezelő használata
/authorName: Visszatér egy JSON objektummal ami tartalmazza az írók neveit
/authors: visszatér egy JSON dokumentummal, amiben benne van az összes adatbázisban tárolt szerző
/author: visszatér egy JSON objektummal amiben benne van a klienstől cookieban kapott szerző könyvei
/addBook: Könyv hozzáadása az adatbázishoz. Ha van már ilyen nevű könyv akkor adjon 409-es hibát
/addAuthor: lásd addBook, de szerzővel.
/updateBook: Könyv frissítése
/: visszatér az index.html-el

Frontendet nem kell megírni hozzá, teszteléséhez otthon postman, védésen egy már elkészített weboldal szolgál
Beadási határidő utolsó óra
Védés menete:
-kód minőség ellenőrzése
-kódrészlet magyarázása
-kódrészlet átírás