package src;

/*

Steg 1: Opprette Spillvinduet (JFrame)

Åpne IntelliJ og lag et nytt Java-prosjekt (uten ekstra biblioteker).
Lag en ny klasse BrickBreakerGame som setter opp et spillvindu.
Her er koden for å lage et enkelt vindu:

✅ Kjør programmet: Du skal nå se et tomt vindu med tittelen "Brick Breaker".

  Steg 2: Legge til Spilleområdet (JPanel)

  vi trenger et tegneområde der vi kan tegne ballen, paddle og mursteinene. Dette gjøres med JPanel og paintComponent().
🔹 Lag en ny klasse GamePanel som skal håndtere alt vi tegner:

🔹 Oppdater BrickBreakerGame for å legge til GamePanel i vinduet:

✅ Kjør programmet igjen: Nå har du et sort bakgrunnsområde – dette er spilleområdet vårt! 🎮

Steg 3: Tegne Paddle, Ball og Mursteiner
Nå legger vi til:

Paddle (rektangel nederst på skjermen)
Ball (en sirkel)
Mursteiner (flere rektangler øverst)
✏️ Oppdater paintComponent i GamePanel slik at vi tegner paddle, ball og mursteiner:

Steg 4: Gjøre Ballen Dynamisk (Bevegelse)
For å animere ballen, må vi:

Opprette en Timer som oppdaterer skjermen regelmessig.
Lagre ballens posisjon og hastighet som variabler.
🏀 Oppdater GamePanel for å inkludere ballbevegelse:

Neste steg:
🎯 Steg 5: Kollisjonshåndtering

Ballen må sprette når den treffer paddle eller murstein.
Bruk Rectangle for å sjekke kollisjoner.
🎯 Steg 6: Brukerinput (Flytte Paddle)

Bruk KeyListener for å styre paddle med piltaster.
Vil du fortsette med kollisjonshåndtering eller paddle-bevegelse først? 😊







Du sa:


 */