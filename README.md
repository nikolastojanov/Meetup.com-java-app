Struktura programa:

Napomena:
Main.x je pomocna promenljiva koja sluzi za dobijanje imena izabranog grada na osnovu unetog rednog broja.

Program prati strukturu dependency injection design pattern-a. 

Writer je osnovna consumer klasa koja izvrsava sve funkcionalnosti.

Svaka funkcionalnost je implementirana kao par klasa getter i decoder.
Getter ima ulogu da posalje http get zahtev na server i primi odgovor.
Decoder ima ulogu da obradi primljeni odgovor i ispise odgovarajuce rezultate na standardni izlaz.

Svaka funkcionalnost ima svoju Injector klasu koja sluzi da inicira Writera za tu funicionalnost.

Jedna od prednosti ovakve strukture je skalabilnost. Ako bi trebalo dodati neku novu funcionalnost (na primer pretazivanje po zadatoj temi ili po datumu odrzavanja dogadjaja), treba napraviti samo novi pra klasa getter/decoder i novi injector.

Uputstvo za upotrebu:

Izvrsni jar fajl se nalazi na lokaciji:
/Meetup.com-java-app/meetup_app/target/meetup_app-1.0-SNAPSHOT.jar

Pri pokretanju program automatski prikazuje listu gradova u Srbiji gde postoji meetup.

Korisnik treba da izabere redni broj grada koji želi.

Program tada ispisuje sve događaje za izabrani grad u formatu:

naziv događaja
    vreme održavanja
    opis događaja

program ostaje aktivan 60 sekundi i tada automatski zaustavlja izvršavanje. 
