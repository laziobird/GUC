//<![CDATA[ js代码
function getPList(){	
	var pid = $("select[name=pid_0]").val(); 
	$("select[name=pid]").empty();		//清空
	if(pid==0){
		var option="<option value='0'>空</option>";  //动态添加数据
		$("select[name=pid]").append(option);		
	}
	else{
		$.ajax({url:'/permission/getPlistByPid',
			type:"GET",
			data:{
				pid : pid
			},
			cache: false,
			error:function(){
			}, 
			success:function(data){
				var plist = data.plist;
				
				var option="<option value='"+pid+"'>新权限</option>";  //动态添加数据
				$("select[name=pid]").append(option);			
				if(plist && plist.length != 0){
					for(var i=0; i<plist.length; i++){
						var option="<option value=\""+plist[i].id+"\"";
						option += ">"+plist[i].name+"</option>";  //动态添加数据
						$("select[name=pid]").append(option);
						}
					}
			}
		});		
	}
	
	

}
//]]>