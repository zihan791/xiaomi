window.onload = function(){
	let showBtn = document.getElementById('showBtn');
	let detailetBox = document.getElementById('detailetBox');
	detailetBox.style.display='none';
	showBtn.onclick = function(){
		if(detailetBox.style.display=='none'){
			detailetBox.style.display='block';
		}else{
			detailetBox.style.display='none';
		}
	}
}