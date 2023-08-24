window.onload = function(){
	document.onscroll = function(){
		//获取滚动条位置
		let s1 = document.documentElement.scrollTop;
		let s2 = document.body.scrollTop;
		let scroll = s1==0?s2:s1;
		
		let width = document.documentElement.clientWidth;
		let search = document.getElementById('fixedBox');
		 if(scroll>width*0.12){
			 search.style.position = 'fixed';
			 search.style.left = '0';
			 search.style.top = '0';
		 }else{
			 search.style.position = 'static';
		 }
	}
}