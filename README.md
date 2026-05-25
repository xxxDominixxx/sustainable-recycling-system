# sustainable-recycling-system
Console based sustainable product and recycling management system

# PROJEKTÖVERSIKT: 
Detta system hanterar möblers miljöpåverkan och ger instruktioner hur man på bästa sätt återvinner olika typer av material. 
SYFTE: 
Syftet med systemet är att hantera produkter och beräkna miljöpåverkan och ge riktlinjer för återvinning. Ska underlätta för att fatta hållbara beslut. 

 ### FUNKTIONALET: 
- Skapa produkter (namn, kategori, beräknad livslängd, produktkomposation)
- Lista befintliga produkter
- Visa detaljerad produktinformation 
- Definiera material och dess miljöpåverkan + återvinning 
- Återvinningsinstruktioner
- Beräkna miljöpåverkan 

### INGÅR INTE:
- Betalningssystem
- Logistik/frakt till kunder 

## SYSTEMKRAV

### FUNKTIONELLA KRAV:
- Skapa och hantera produkter
- Koppla material till produkter
- Beräkna total miljöpåverkan
- Ge återvinningsguiden instruktioner 

### ICKE FUNKTIONELLA KRAV:
PRESTANDA: 
- Systemet ska hantera minst 100 samtidiga användare

ANVÄNDBARHET:
- Enkel att använda
- Enkel att underhålla och vidareutveckla 
 
ARKITEKTUR 
- Tydlig separation mellan input/output 

# DOMÄNMODELL

## DOMÄNBEGREPP:
- Produkt
- Material
- Miljöpåverkan
- Livslängd


## VERBDOMÄN:
- Registrera produkt 
- Beräkna miljöpåverkan
- Lista produkter

## KLASSIFICERING
ENTITIES: 
- Produkt(ID)
- Återvinningsprocess
- Material 

### VALUE OBJECTS:
- Miljöpåverkan
- Livslängd

### SERVICES: 
- MiljöpåverkanService
- ÅtervinningsService 

### UNSURE:
- Meny

# ARKITEKTURELLA BESLUT:

Systemet är uppbyggt enligt en lagerarkitektur med fyra lager:

## DOMÄNLAGER:
- Product
- Material
- RecyclingGuidance
- RecyclingCategory 
- CalculateImpact
- ProductStorage

## APPLIKATIONSLAGER:
- ProductService - ska styra allt som har med Product 
- SimpleImpactCalculator - den använder CalculateImpact - implementerar logik 
- MaterialService - hanterar Material och eventuellt filtrerar och hittar material 
- RecyclingService - går igenom material och returnerar instruktioner för återvinning

## PRESENTATIONSLAGER: 
- ConsuleMenu 
- ProductMenu
- MaterialMenu
- RecyclingMenu 

## INFRASTRUKTURLAGER: 
- MemoryStorage - implementera utifrån interface ProductStorage 

## INTERFACES:
CalculateImpact ligger i domänlagret och bestämmer hur miljöpåverkan ska räknas ut och implementeras sen i applikationslagret SimpleImpactCaculator.
ProductStorage ligger  i domänlagret och bestämmer hur produkter ska spara och hämtas och implementeras sen i infrastrukturslagret MemoryStorage. 


## DESIGN PATTERNS: 

### Strategy Pattern - Beräkning för miljöpåverkan 
Systemet ska ha möjlighet till att beräkna miljöpåverkan på önskat sätt, antingen en summering av produktens totala miljöpåverkan eller genom uträkning av produktens livsspann.

För att möjliggöra detta används Strategy Pattern. Interfacet `CalculateImpact` definierar ett gemensamt kontrakt för hur beräkningen ska utföras, medan konkreta implementationer som `SimpleImpactCalculator` och `LifespanImpactCalculator` ansvarar för den faktiska beräkningslogiken. Klasserna i sig står sedan för implementation av beräkningslogiken. 

Om denna logik istället hade placerats direkt i `ProductService` skulle klassen behöva ändras varje gång en ny beräkningsmetod införs, vilket bryter mot Open/Closed Principle (OCP). Genom att använda Strategy Pattern kan nya beräkningsstrategier läggas till utan att ändra befintlig kod. Nu förbättras designen eftersom den blir mer flexibel och lättare att utöka vid framtida behov om till exempel nya beräkningsmetoder behöver läggas till. 

Förbättrar designen genom att:
- Gör det enkelt att lägga till nya beräkningsmetoder
- Minskar kopplingen mellan klasser
- Lättare att testköra


### Factory Pattern – Återvinningshantering

För att hantera olika typer av återvinning används Factory Pattern. 

`RecyclingGuidanceFactory` ansvarar för att skapa rätt typ av återvinningshantering baserat på materialets egenskaper. 

Tidigare placerades den direkt i `RecyclingService` och innehöll villkorssatser som case/switch för varje typ av material eller återvinningsfall. Detta gjorde koden svårare att underhålla och mindre flexibel vid utökning av kod. 

'RecyclingService' skapar rätt objekt med hjälp av 'RecyclingGuidanceFactory'. Factory gör systemet mer flexibelt och enklare att vidareutveckla med nya återvinningsregler eftersom det då endast är factoryn som behöver ändras. 

Detta förbättrar designen genom att:
- Mindre koppling mellan delar av systemet
- Allt skapas på ett ställe
- Lätt att utöka 

  






## BEROENDERIKTNING: 
Presentationslager -> Applikationslager -> Domänlager 
Infrastrukturlagret ligger under domänlagret. 


# SYSTEMFLÖDEN 
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

## Sekvensdiagram

Sekvensdiagrammet  visar `createProduct`-flödet i systemet.

Diagrammet visar hur:
- konsolmenyn startar flödet
- användarens input omvandlas till en CreateProductRequest
- ProductService skapar produkten
- SimpleImpactCalculator räknar ut miljöpåverkan
- resultatet skickas tillbaka och skrivs ut för användaren

[Visa Sequence Diagram](sequence-diagram-create-product.png)


TEAM:

Dominik Biscan - Projekt manager

Charlotta Kroksson - Software Arkitekt 

Felicia Hornesjö - BackEnd Developer

Mimoza Hysenaj - FrontEnd Developer






