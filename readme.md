Witam w moim projekcie "Oddam w dobre ręce".
Projekt w trakcie...

Celem projektu jest stworzenie miejsca, w którym każdy będzie mógł oddać niepotrzebne rzeczy zaufanym instytucjom.

Użyte technologie:

    Spring Boot
    Spring Form
    Hibernate
    Spring Data JPA


Gotowa wersja podstawowa:
    Landing page, który ma zachęcać do skorzystania z aplikacji.
    Dodawanie darów


Wersja Rozszerzona będzie zawierała lub częściowo już zawiera:

1. Profil administratora:
- logowanie, /DONE/
- zarządzanie (**CRUD**) administratorami, /TODO/
- zarządzanie (**CRUD**) zaufanymi instytucjami,/TODO/
- przeglądanie, edycja, usuwanie zarejestrowanych użytkowników, /TODO/
- przegląd przekazanych darów. /TODO/
-  możliwością określenia statusów darów (złożone/odebrane/przekazane) /TODO/
   ( dodajemy dodatkową encję oraz powiązanie dla statusów)
2. Profil użytkownika:
- rejestracja, /DONE/
- logowanie (ten sam formularz co dla administratora), /DONE/
- edycja własnego profilu (podstawowe dane),/TODO/
- dodawanie darów tylko po zalogowaniu, /TODO/
- przeglądanie, edycja, kasowanie przekazanych darów, /TODO/
- zaznaczenie, że dar został komuś oddany (archiwizacja). /TODO/

-----------------------------------------------------------------

W ramach wersji rozszerzonej wprowadzamy:
- role użytkowników (ROLE_USER, ROLE_ADMIN) /DONE/
- panel adminstracyjny /TODO/



-----
## Dodatkowe funkcjonalności
- potwierdzenie aktywacji konta poprzez wiadomość przesłaną na email podany przy rejestracji,/TODO/
- obsługa zapomnianych haseł,/TODO/
- walidacja poprawnego podania dwóch identycznych haseł,/TODO/
- walidacja obsługi administratorów (np. brak możliwości skasowania ostatniego istniejącego administratora)./TODO/