var players = [
{nev:'Barbay Ádám', kep:'Images/meretezettek/BarbayAdam.jpg'},
{nev: 'Bodóczky Mihály', kep:'Images/meretezettek/BodoczkyMihaly.jpg'},
{nev: 'Czető Márton', kep:'Images/meretezettek/CzetoMarton.jpg'},
{nev: 'Decsics Gergely', kep:'Images/meretezettek/DecsicsGergely.jpg'},
{nev: 'Diera Andor', kep:'Images/meretezettek/DieraAndor.jpg'},
{nev: 'Hadiné Gubics Andrea', kep:'Images/meretezettek/GubicsAndrea.jpg'},
{nev: 'Hallak Hella', kep:'Images/meretezettek/HallakHella.jpg'},
{nev:'Molnár László', kep:'Images/meretezettek/MolnarLaszlo.jpg'},
{nev:'Németh Zoltán', kep:'Images/meretezettek/NemethZoltan.jpg'},
{nev:'Rátkay András', kep:'Images/meretezettek/RatkayAndras.jpg'},
{nev:'Sándor Zoltán Péter', kep:'Images/meretezettek/SandorPeter.jpg'},
{nev:'Soltész Alexander', kep:'Images/meretezettek/SolteszAlexander.jpg'},
{nev:'Szabó Erik Márk', kep:'Images/meretezettek/SzaboErik.jpg'},
{nev:'Szabó Péter', kep:'Images/meretezettek/SzaboPeter.jpg'},
{nev:'Szilberhorn Zoltán', kep:'Images/meretezettek/SzilberhornZoltan.jpg'},
{nev:'Taigiszer Dóra', kep:'Images/meretezettek/TaigiszerDora.jpg'},
{nev:'Timpfel Gábor', kep:'Images/meretezettek/TimpfelGabor.jpg'},
{nev:'Tóth Sára', kep:'Images/meretezettek/TothSara.jpg'},
{nev:'Mező Imre', kep:'Images/meretezettek/MezoImre.jpg'},
{nev:'Koncz Gergely', kep:'Images/meretezettek/KonczGergely.jpg'},
];

var players_null= [
{nev:'Barbay Ádám', kep:'Images/meretezettek/BarbayAdam.jpg'},
{nev: 'Bodóczky Mihály', kep:'Images/meretezettek/BodoczkyMihaly.jpg'},
{nev: 'Czető Márton', kep:'Images/meretezettek/CzetoMarton.jpg'},
{nev: 'Decsics Gergely', kep:'Images/meretezettek/DecsicsGergely.jpg'},
{nev: 'Diera Andor', kep:'Images/meretezettek/DieraAndor.jpg'},
{nev: 'Hadiné Gubics Andrea', kep:'Images/meretezettek/GubicsAndrea.jpg'},
{nev: 'Hallak Hella', kep:'Images/meretezettek/HallakHella.jpg'},
{nev:'Molnár László', kep:'Images/meretezettek/MolnarLaszlo.jpg'},
{nev:'Németh Zoltán', kep:'Images/meretezettek/NemethZoltan.jpg'},
{nev:'Rátkay András', kep:'Images/meretezettek/RatkayAndras.jpg'},
{nev:'Sándor Zoltán Péter', kep:'Images/meretezettek/SandorPeter.jpg'},
{nev:'Soltész Alexander', kep:'Images/meretezettek/SolteszAlexander.jpg'},
{nev:'Szabó Erik Márk', kep:'Images/meretezettek/SzaboErik.jpg'},
{nev:'Szabó Péter', kep:'Images/meretezettek/SzaboPeter.jpg'},
{nev:'Szilberhorn Zoltán', kep:'Images/meretezettek/SzilberhornZoltan.jpg'},
{nev:'Taigiszer Dóra', kep:'Images/meretezettek/TaigiszerDora.jpg'},
{nev:'Timpfel Gábor', kep:'Images/meretezettek/TimpfelGabor.jpg'},
{nev:'Tóth Sára', kep:'Images/meretezettek/TothSara.jpg'},
{nev:'Mező Imre', kep:'Images/meretezettek/MezoImre.jpg'},
{nev:'Koncz Gergely', kep:'Images/meretezettek/KonczGergely.jpg'},
];


var teamNames= [
'Meccsetnyer United',
'Winchester United',
'Necseszdel United',
'Asztalon Villa',
'Aston Vilma',
'Keverton',
'West Ham And Eggs',
'Chrystal Paraszt',
'Csel-C',
'Vígan Athletic',
'Májmedence (Liverpool)',
'FC Hordeaux',
'Fanatinaikhos',
'HOFI Kréta',
'Ronda JC',
'Verdel Szépen',
'Májjer Müntyen',
'Hamza Rossz tok',
'ACid Milan',
'ReLazio',
'AS Kóma',
'SSC Nápolyi',
'Sporting Libacomb',
'Benn Fika',
'Alcoholic Bilbao',
'Athletrico Madrid',
'Reál Margit',
'Reál Morbid',
'Irreal Madrid',
'Szeszspanyol',
'Deportivo Nyakonrúglak',
'Real Betlis',
'Sevilla Sekanál',
'Maláta Szeráj',
'A kispad legjobbjai',
'Albán focisuli',
'Beer-Bar-Bárok',
'BKV Hátra',
'Brazil Gépsor',
'Drink Team',
'Egy gólt SE',
'Etil alakulat',
'Felrúglak oszt LSL',
'Gyermekláncfűrész',
'Hanyatt SE',
'In-Team',
'Játék Csatárok Nélkül',
'Kóma Sutra',
'Maholka Punki',
'Nyerőmű',
'Sivatagi Rohamcsigák',
'TTK-Tré Tőlünk Kikapni',
'Úgyis a talajra fogjuk'
];

var teamNames_null= [
'Meccsetnyer United',
'Winchester United',
'Necseszdel United',
'Asztalon Villa',
'Aston Vilma',
'Keverton',
'West Ham And Eggs',
'Chrystal Paraszt',
'Csel-C',
'Vígan Athletic',
'Májmedence (Liverpool)',
'FC Hordeaux',
'Fanatinaikhos',
'HOFI Kréta',
'Ronda JC',
'Verdel Szépen',
'Májjer Müntyen',
'Hamza Rossz tok',
'ACid Milan',
'ReLazio',
'AS Kóma',
'SSC Nápolyi',
'Sporting Libacomb',
'Benn Fika',
'Alcoholic Bilbao',
'Athletrico Madrid',
'Reál Margit',
'Reál Morbid',
'Irreal Madrid',
'Szeszspanyol',
'Deportivo Nyakonrúglak',
'Real Betlis',
'Sevilla Sekanál',
'Maláta Szeráj',
'A kispad legjobbjai',
'Albán focisuli',
'Beer-Bar-Bárok',
'BKV Hátra',
'Brazil Gépsor',
'Drink Team',
'Egy gólt SE',
'Etil alakulat',
'Felrúglak oszt LSL',
'Gyermekláncfűrész',
'Hanyatt SE',
'In-Team',
'Játék Csatárok Nélkül',
'Kóma Sutra',
'Maholka Punki',
'Nyerőmű',
'Sivatagi Rohamcsigák',
'TTK-Tré Tőlünk Kikapni',
'Úgyis a talajra fogjuk'
];













// alert('Összekötve');
var teams={};
var Lista=[];

function teamNameGenerator(){
	// a teamNames tömbből kiválaszt 1 random csapatnevet
	
		 var randomTeamNameIndex = Math.floor(Math.random()*(teamNames.length));
		 teamName=teamNames.splice(randomTeamNameIndex,1)[0];

	return teamName;
}

function teamGenerator(){			
			var teamPlayers=[];
			var team=[];		
				var j=0;
				// while ciklus mert 2 fős csapatok kellenek
				while(j<2){
				var randomPlayerIndex = Math.floor(Math.random()*(players.length));
				player=players.splice(randomPlayerIndex,1)[0];
				teamPlayers.push(player.nev);
				j++;
				}
			// a team objektumba teamName megnevezésssel beillesztem a csapatnevet
			team.teamName=teamNameGenerator();
			// a team objektumba teamName megnevezésssel beillesztem a két játékost egy tömbbel
			team.Player1=teamPlayers[0];
            team.Player2=teamPlayers[1];
            team.win=0;
            team.loss=0;
            team.golok=0;
            team.pont=0;
			return team;
}

function teamGrouping(){
    var group=[];
    var nodeSorsolasTabla= document.querySelector("#sorsolas > table > tbody");	
 
    nodeSorsolasTabla.innerHTML=" ";    
	for(var i=0;i<10;i++){
        group[i]=teamGenerator();
        
        nodeSorsolasTabla.innerHTML+='<tr><td>'+ group[i].teamName +'</td><td>'+ group[i].Player1 +'</td><td>'+ group[i].Player2 +'</td></tr>';
    } 
    players=players_null.concat();
    teamNames=teamNames_null.concat();
    
    for (var j=0; j<group.length; j++)
        {
            Lista[j]=group[j];
        }
    return group;
    
}


function Tabella()
{
	var teamGroup = teamGrouping();
	
	var nodeTabellaTbody = document.querySelector("#tabella > table > tbody");
	var s = '';
	
	for(var i=0; i<teamGroup.length; i++)
	{
		s += '<tr>';
		s += '<td>' + teamGroup[i].teamName + '</td>';
		s += '<td>' + + '</td>';
		s += '<td>' + + '</td>';
		s += '<td>' + + '</td>';
		s += '<td>' + + '</td>';
		s += '</tr>';
	}
    nodeTabellaTbody.innerHTML = s;
}


	function kovetkezo_Meccs(){
			for(var i=0; i<Lista.length-1; i++)
	{	
			db=elsoCsapat();
			window.setTimeout(elsoCsapat, i*9000,i);	
		
			}
			window.setTimeout(listazas, 82000);	
			}

function elsoCsapat(i)
{
	for (var j=i+1; j<Lista.length; j++)
				{
	window.setTimeout(masodikCsapat, j*1000,i, j);
				}

}
	
function masodikCsapat(i,j)
{		
			
						var egyes = Math.floor(Math.random()*9)+0;
						var kettes = 9 - egyes;
						console.log(i +' '+Lista[i].teamName);
						console.log(j + ' ' +Lista[j].teamName);
						Lista[i].golok+=egyes;
						Lista[j].golok+=kettes;
						// itt generáljuk a Kommenteket a két cikluson belül
						pillanatnyiJatekosokFeltoltese(i,j);
						kommentBeszur();
						kepGenerator(i,j);					
						eredmenyKiir(egyes, kettes);
						//a second konstans aktuális értékét mindig kivonja a jelenlegi időből,
						//és addig nem megy tovább amíg a különbség nem a megadott
						
						if (egyes>kettes)
							{
								console.log(Lista[i].teamName + 'csapat nyert');
								Lista[i].win++;
								Lista[i].pont=Lista[i].pont+3;
								Lista[j].loss++;
							
							}
						else 
							{
								 console.log(Lista[j].teamName + 'csapat nyert');
								Lista[j].win++;
								Lista[j].pont=Lista[j].pont+3;
								Lista[i].loss++;
								
								
							}
					
}
function kepGenerator(i,j)
{
	var bal1=document.querySelector('#bal1');
	var jobb1=document.querySelector('#jobb1');
	var bal2=document.querySelector('#bal2');
	var jobb2=document.querySelector('#jobb2');

	for (var k=0; k<players.length; k++)
	{
		if (Lista[i].Player1==players[k].nev)
		{
			bal1.innerHTML='<img src=' + players[k].kep + '>';
		}
	}
	for (var l=0; l<players.length; l++)
	{
			if (Lista[i].Player2==players[l].nev)
		{
			jobb1.innerHTML='<img src=' + players[l].kep + '>';
		}
	}
		for (var m=0; m<players.length; m++)
	{
			if (Lista[j].Player1==players[m].nev)
		{
	bal2.innerHTML='<img src=' + players[m].kep + '>';
		}
	}
		for (var m=0; m<players.length; m++)
	{
			if (Lista[j].Player2==players[m].nev)
		{
	jobb2.innerHTML='<img src=' + players[m].kep + '>';
		}
	}
}

function eredmenyKiir(egyes, kettes)
{
	var nodeEredmeny1=document.querySelector("#eredmeny1");
	nodeEredmeny1.innerText=egyes;
	var nodeEredmeny2=document.querySelector("#eredmeny2");
	nodeEredmeny2.innerHTML=kettes;
}

function listazas(){
    for (var i=0; i<Lista.length-1; i++)
    {
         for (var j=i+1; j<Lista.length; j++)
        {
            if (Lista[i].pont<Lista[j].pont){
                var csere=[Lista[i],Lista[j]];
                Lista[i]=csere[1];
                Lista[j]=csere[0];
            }
        }   
    }

    var nodeTabellaTbody = document.querySelector("#tabella > table > tbody");
    var s = '';
    
    for(var l=0; l<Lista.length; l++)
    {
        s += '<tr>';
        s += '<td align="center">' + Lista[l].teamName + '</td>';
        s += '<td align="center">' + Lista[l].win + '</td>';
        s += '<td align="center">' + Lista[l].loss + '</td>';
        s += '<td align="center">' + Lista[l].golok + '</td>';
        s += '<td align="center">' + Lista[l].pont + '</td>';
        s += '</tr>';
    }
    nodeTabellaTbody.innerHTML = s;
}


function pillanatnyiJatekosokFeltoltese(i,j){
	jatekosok= [];
		//console.log('jatekos feltoltes: '+ i + ' ' + j)
	jatekosok.push(Lista[i].Player1);
	jatekosok.push(Lista[i].Player2);
	jatekosok.push(Lista[j].Player1);
	jatekosok.push(Lista[j].Player2);
	jatekosok.push(Lista[i].Player1);
	jatekosok.push(Lista[i].Player2);
	jatekosok.push(Lista[j].Player1);
	jatekosok.push(Lista[j].Player2);
	console.log(jatekosok);
}

function CsocsoKommentarNevekkel()
{
	var kommentekNevekhez = [' lő, ha bemegy, biztos gól lett volna.',
' meg köti a cipőjét... Még szerencse, hogy gyerekkorábn gyakorolta, mert most nagy szüksége van rá!',
' tipikus svéd kapus: beállt a kapuba, s véd.',
' csak vár, de nem jönnek neki segíteni csak a szomszéd utcában jött egy Citroen Picasso.',
' a kapus. Komolyan kell összpontosítania, hogy ne dőljön el addig, amíg a labda odaér. ',
' lő, Éssss szenzációs gól! ..Lett volna, ha kapura megy...',
' te meg hogy lejmoltad össze a labdát?',
' messziről lőtt kapura, de nem túl pontosan.',
' pedig védőmunkát végzett... de úgy látom nem annyira van térlátása',
' megszerzi a labdát, ééés újabb gól!!!',
' de nagy gólt lőttél! Mondhatnám, hogy ez a Bélák napja, de hát ő nem is Béla...',
' megszerezte a labdát, és ott egy lövés: GÓÓÓL',
' helyzetben!, mindjárt lőni fog, lőőő.. .. ... és mégsem.',
' lövése hihetetlenül pontos és precíz volt, csak éppen mellément.',
' labdája úgy megy át a védelmen, mint vaj a késen.',
' tör előre, lecselez mindenkit – a kapust is. ÉÉÉÉéééés... mellléééé rúgta',
' bebőrözte a jobb felső sarokba... szép!',
' ,na ez flegma volt',
' ez is nagy helyzet volt, minthogy majdnem öngólt hozott össze a védelem!',
' vigyázz, egy bogár volt a labdán, remélem, elugrott...'];
	



	var kommentekNevekhezTomb = [];
	for (var i = 0; i<8; i++)
		{
		var kommentarNevekkelIndex = Math.floor(Math.random()*(kommentekNevekhez.length));
		kommentek=kommentekNevekhez.splice(kommentarNevekkelIndex,1)[0];
		kommentekNevekhezTomb.push(kommentek);		
		}
		
	return kommentekNevekhezTomb;
	
}

function KommentOsszefuzo ()
{
	var kommentek8 = CsocsoKommentarNevekkel();
	var nevek8 =jatekosok
	var kommentTeljes = [];
	for (var i = 0; i<8; i++)
	{	
	
	
	kommentTeljes.push(nevek8[i] + " " + kommentek8[i] + '\n');
	}
	
	// Itt Szúrom be az önálló szöveget
	kommentTeljes.splice(4,0,CsocsoKommentarOnallo());
	kommentTeljes.splice(9,0,CsocsoKommentarOnallo());
	//console.log('Teljes komment: '+ kommentTeljes);
	return kommentTeljes;
}	

function CsocsoKommentarOnallo()
{
	var kommentekOnallo =[' Kik ezek a sárga mezesek?',
	' Srácok pörögni kellene, mint a sündisznónak a turmixgépben!',
	' Összesen ötször volt lehetőségük, de mindegyikben ott volt a gólcsíra... egy az ki is nőtt.',
	' Most nem akarok beleszólni, mert gyásszünet van.',
	' Mező Imre csapatkapitány nincs ma itt, ami azt sugallja, hogy máshol van.',
	' Hatalmasak ezek a Yellowroados játékosok, betöltik az egész képernyőt.',
	' Ezek NBII-es kettes futballsitak faszom :D',
	' Erre mondják sportszakmai szempontból, hogy mélytorok. Lefőtt a kávé.',
	' Milyen jól el lehetne adni ezeket a játékosokat, ha gépkocsik lennének. Az eladónak csak annyit kellene mondania: ezt nézze uram, alig futott.',
	' Az előbb azt mondtam, hogy két jó passzban lévő csapat találkozik, hát most nem ártana két jó passz...'
]
	
	
		var kommentarOnalloIndex = Math.floor(Math.random()*(kommentekOnallo.length));
		kommentek2=kommentekOnallo.splice(kommentarOnalloIndex,1)[0];
		return kommentek2;
}


function kommentBeszur()
{	var kommentek = [];
	kommentek=KommentOsszefuzo();
	
	var nodeKommentTbody = document.querySelector("#komment");
	var s = '';
	
	

		s += '<li>' + kommentek[0] + '</li><br>';
		s += '<li>' + kommentek[1] + '</li><br>';
		s += '<li>' + kommentek[2] + '</li><br>';
		s += '<li>' + kommentek[3] + '</li><br>';
		s += '<li>' + kommentek[4] + '</li><br>';
		s += '<li>' + kommentek[5] + '</li><br>';
		s += '<li>' + kommentek[6] + '</li><br>';
		s += '<li>' + kommentek[7] + '</li><br>';
		s += '<li>' + kommentek[8] + '</li><br>';
		s += '<li>' + kommentek[9] + '</li><br>';
		
	
    nodeKommentTbody.innerHTML = s;
}


