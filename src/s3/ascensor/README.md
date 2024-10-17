## L'Ascensor

L'**Ascensor** és un objecte que ha de ser agafat per **persones**.  
El seu estat es defineix a partir del pis en què es troba, 
la quantitat de persones que hi ha a dins, si està plè, quina capacitat té
i si està pujant o baixant.  
El seu comportament és principalment monitoritzar el seu us, i aquestes en són les condicions:  
 - Un persona pot entrar-hi si no està plè
 - Una persona cal que surti de l'ascensor quan hagi arribat al pis on vol anar
 - L'ascensor sempre fa un recorregut seqüencial, és a dir, va del pis 0 al pis 10 i després torna al pis 0.
  A mig edifici l'ascensor mai canvia de sentit. De manera que si una persona es troba per sobre
  del pis on vol anar i l'ascensor està pujant, aquesta pot pujar, però l'ascensor
  continuarà pujant i no serà fins que faci el recorregut descendent que arribarà al pis que li toca i en podrà sortir.
 - És ell mateix l'encarregat de determinar quin és el següent pis i on li toca anar, però és un motor independent
  qui el fa moure per anar al següent pis.
   
El **Motor** és un procés al qual se li encomana principalment fer moure l'ascensor.  

Les **Persones** han de tenir un nom i se'ls hi ha d'assignar un ascensor perquè el puguin fer servir. Aquestes serán un procés
on la seva tasca principal serà determinar en quin pis es troben i triar a quin altre pis es volen dirigir. Aleshores entrar-hi
quan sigui possible i baixar, també, quan sigui possible.