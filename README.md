# sustainable-recycling-system
Console based sustainable product and recycling management system

PROJEKTÖVERSIKT: 
Detta system hanterar möblers miljöpåverkan och ger instruktioner hur man på bästa sätt återvinner olika typer av material. 
SYFTE: 
Syftet med systemet är att hantera produkter och beräkna miljöpåverkan och ge riktlinjer för återvinning. Ska underlätta för att fatta hållbara beslut. 

FUNKTIONALET: 
- Skapa produkter (namn, kategori, beräknad livslängd, produktkomposation)
- Lista befintliga produkter
- Visa detaljerad produktinformation 
- Definiera material och dess miljöpåverkan + återvinning 
- Återvinningsinstruktioner
- Beräkna miljöpåverkan 

INGÅR INTE:
- Betalningssystem
- Logistik/frakt till kunder 

SYSTEMKRAV

FUNKTIONELLA KRAV:
- Skapa och hantera produkter
- Koppla material till produkter
- Beräkna total miljöpåverkan
- Ge återvinningsguiden instruktioner 

ICKE FUNKTIONELLA KRAV:
PRESTANDA: 
- Systemet ska hantera minst 100 samtidiga användare

ANVÄNDBARHET:
- Enkel att använda
- Enkel att underhålla och vidareutveckla 
 
ARKITEKTUR 
- Tydlig separation mellan input/output 

DOMÄNMODELL

DOMÄNBEGREPP:
- Produkt
- Material
- Miljöpåverkan
- Livslängd


VERBDOMÄN:
- Registrera produkt 
- Beräkna miljöpåverkan
- Lista produkter

KLASSIFICERING
ENTITIES: 
- Produkt(ID)
- Återvinningsprocess
- Material 

VALUE OBJECTS:
- Miljöpåverkan
- Livslängd

SERVICES: 
- MiljöpåverkanService
- ÅtervinningsService 

UNSURE:
- Meny

SYSTEMFLÖDEN 
SKAPA PRODUKT 
1. Användare anger produktdata
2. Material kopplas till produkten 
3. Systemet sparar produkten

BERÄKNA MILJÖPÅVERKAN
1. Hämta produktens material
2. Beräkna den totala miljöpåverkan 
3. Returnera den totala miljöpåverkan 

ÅTERVINNINGSGUIDE
1. Identifiera material
2. Hantera blandmaterial
3. Visa återvinningsinstruktion 


TEAM:

Dominik Biscan - Projekt manager

Charlotta Kroksson - Software Arkitekt 

Felicia Hornesjö - BackEnd Developer

Mimoza Hysenaj - FrontEnd Developer






