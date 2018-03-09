var autok=[
{id:'p1', marka:'Fiat', tipus:'500', evjarat:'2016', hengerUrtartalom:1200 , napidij:8000 , vetelar:2990000, path:'Images/Fiat_500.jpg' },
{id:'p2', marka:'Fiat', tipus:'Tipo', evjarat:'2012', hengerUrtartalom:1200, napidij:9000 , vetelar:2000000, path:'Images/Fiat_Tipo.jpg' },
{id:'p3', marka:'Fiat', tipus:'Punto', evjarat:'2014', hengerUrtartalom:2000, napidij:12000 , vetelar:2200000, path:'Images/Fiat_Punto.jpg'},
{id:'p4', marka:'Ford', tipus:'Fiesta', evjarat:'2015', hengerUrtartalom:2000, napidij:9000 , vetelar:2500000, path:'Images/Ford_Fiesta.jpg'},
{id:'p5', marka:'Ford', tipus:'Focus', evjarat:'2013', hengerUrtartalom:1800, napidij:11000 , vetelar:2150000, path:'Images/Ford_Focus.jpg'},
{id:'p6', marka:'Ford', tipus:'Mondeo', evjarat:'2017', hengerUrtartalom:1200, napidij:20000 , vetelar:6500000, path:'Images/Ford_Mondeo.jpg'},
{id:'p7', marka:'Opel', tipus:'Corsa', evjarat:'2011', hengerUrtartalom:1600, napidij:7000 , vetelar:2650000, path:'Images/Opel_Corsa.jpg'},
{id:'p8', marka:'Opel', tipus:'Astra', evjarat:'2014', hengerUrtartalom:2000, napidij:9500 , vetelar:3000000, path:'Images/Opel_Astra.jpg'},
{id:'p9', marka:'Opel', tipus:'Insignia', evjarat:'2016', hengerUrtartalom:1600, napidij:15000 , vetelar:8500000, path:'Images/Opel_Insignia.jpg'},
{id:'p10', marka:'Skoda', tipus:'Fabia', evjarat:'2008', hengerUrtartalom:1200, napidij:8500 , vetelar:1250000, path:'Images/Skoda_Fabia.jpg'},
{id:'p11', marka:'Skoda', tipus:'Octavia', evjarat:'2009', hengerUrtartalom:1800, napidij:10000 , vetelar:1800000, path:'Images/Skoda_Octavia.jpg'},
{id:'p12', marka:'Skoda', tipus:'Superb', evjarat:'2010', hengerUrtartalom:2000, napidij:12000 , vetelar:2100000, path:'Images/Skoda_Superb.jpg'},
{id:'p13', marka:'Suzuki', tipus:'Ignis', evjarat:'2008', hengerUrtartalom:2000, napidij:7500 , vetelar:950000, path:'Images/Suzuki_Ignis.jpg'},
{id:'p14', marka:'Suzuki', tipus:'Swift', evjarat:'2012', hengerUrtartalom:1200, napidij:8000 , vetelar:1100000, path:'Images/Suzuki_Swift.jpg'},
{id:'p15', marka:'Suzuki', tipus:'Vitara', evjarat:'2015', hengerUrtartalom:2000, napidij:10000 , vetelar:1350000, path:'Images/Suzuki_Vitara.jpg'}]


function detailsShowHandler(){
 	var selectedValue;
 	var searchValue;
 	var nodeSelectListBox;

 	searchValue=null;
 	// visszakapom az optionBox value-t
 	nodeSelectListBox = document.getElementById("lstAutok");
    searchValue = nodeSelectListBox.options[nodeSelectListBox.selectedIndex].value;
    //alert(nodeSelectListBox.options[nodeSelectListBox.selectedIndex].value);


    // ha megfelel a feltételnek akkor visszaírom a tömbböl az adatokat a selectedValue egy tömb

    selectedValue=getCar(searchValue);
    if(selectedValue !=null)
    {
   	 document.getElementById('car_name').innerHTML=selectedValue.marka+ ' '+ selectedValue.tipus;
     document.getElementById('year').innerHTML='Gyártási év: '+selectedValue.evjarat;
     document.getElementById('ccm').innerHTML='Köbcenti: '+selectedValue.hengerUrtartalom;
     document.getElementById('daily_cost').innerHTML='Napi díj: '+selectedValue.napidij;
     document.getElementById('purchase_price').innerHTML='Vételár: '+selectedValue.vetelar;
     document.getElementById('car_img').src=selectedValue.path;
	 document.getElementById("napokSzama").value = "";
	 document.getElementById("txtFutamido").value = "";
    }
}

function MakeButtonsAppear () {
  document.getElementById("buttons").style.display = "flex";
}

function SealTheDealAppear () {
  document.getElementById("sealTheDeal").style.display = "block";
}

function changePic () {
  document.getElementById("sealTheDealButton").innerHTML = "<img src='Images/Peanut-butter-jelly-time.gif'>";
}

function berletiDijSzamitas()
	{
		searchValue=null;
 	// visszakapom az optionBox value-t
 	nodeSelectListBox = document.getElementById("lstAutok");
    searchValue = nodeSelectListBox.options[nodeSelectListBox.selectedIndex].value;
	selectedValue=getCar(searchValue);
	var bereltNapokSzama = document.getElementById("napokSzama").value;
	var berletiDij = 0;
	var napiDij = parseInt(selectedValue.napidij);
	var berletiDijTextBox = document.getElementById("berletiDij");
	berletiDij = bereltNapokSzama * napiDij;
	berletiDijTextBox.value = berletiDij;
	}

function getCar(sValue){
		for(var i=0;i<autok.length;i++){
				if(sValue==autok[i].id){
				return autok[i];
				}
			}
}

function reszletKiszamitasaButton_ClickHandler(){
	searchValue=null;

	nodeSelectListBox = document.getElementById("lstAutok");
    searchValue = nodeSelectListBox.options[nodeSelectListBox.selectedIndex].value;
	selectedValue = getCar(searchValue);

	var vetelar;
	vetelar = selectedValue.vetelar;
	var kamat;
	kamat = 0.0035;
	var honap = document.getElementById("txtFutamido").value;
	honap = parseInt(honap);
	var haviTorleszto;
	console.log(vetelar);

for (var i = 0; i < honap; i++){
	vetelar += (vetelar*kamat);
	}
haviTorleszto = vetelar / honap;
document.getElementById("txtReszlet").value = Math.round(haviTorleszto);
}

function makeTextAppear (contentToAppear, contentToDisappear) {
  var content_to_appear = document.getElementById(contentToAppear);
  var content_to_disappear = document.getElementById(contentToDisappear);

  if (content_to_appear.style.display == 'none') {
    content_to_appear.style.display = 'block';
  }
  if (content_to_disappear.style.display == 'block') {
    content_to_disappear.style.display = 'none';
  }
}
