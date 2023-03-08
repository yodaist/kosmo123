<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<article >



        <header>
            <h1>Survey Detail Demo</h1>
        </header>
        <ul class="list-unstyled"><li class="border-top my-3"></li></ul>
<div>
<%-- form start --%>
<form action="addSurveyClient" method="post">
 <table class="table">
		<thead>
			<tr>
				<th colspan="2">SurveyDetail</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<th>����</th>
			<td>
			<input type="text" name="sub" id="sub" value="${vo.sub}"
							readonly="readonly"> 
		   <input type="hidden" name="subcode" id="num" value="${vo.num}">
		   <input type="hidden" name="scid" id="scid" value="${sessionScope.sessionID}">
		   <input type="hidden" name="sccode" id="sccode" value="${vo.num}">
		 
		   
			</td>
			</tr>
			<c:forEach var="e" items="${vo.subvey}" varStatus="i">
				<tr>
					<th>${i.index+1}�� ���� ���� 
					<input type="radio" name="subtype" value="${e.subtype}">
					${e.subtype }</th>
					<td>${e.surveytitle}</td>
				</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="2">
				 
				
				
				<input type="submit" value="��ǥ�ϱ�" >
				<input type="button" value="list"
					onclick="location='surveylist'">
				</th>
				
			<!--  
				<th colspan="2">
				<a href="surveylist">
				<input type="button" value="list"></a></th>
			-->
			</tr>
			<tr>
			<td id="chk">check</td>
			</tr>
		</tfoot>
	</table>
	</form>
</div>
</article>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>


/*$(function(){
    $('#check').click(function(){
       let sccode = ${vo.num};
       let scid = ${sessionScope.sessionID};
  	
        $.ajax({
        	url:"surveycheck?sccode="+${vo.num}+"&scid="+${sessionScope.sessionID},
        	
      //      url:"surveycheck?scode=${vo.num}&scid=${sessionScope.sessionID}",
         //   type : "post",
            data : {
            	sccode : ${vo.num}
            	scid : ${sessionScope.sessionID}
            	
            },	 
            success:function(data){
            
                console.log(data);
                if(data == 1){
                    /* $('#target').css('background-color','red')
                    .css('color','white').html('��ǥ��.');
                    
                    console.log('if����');
                }else{
                    $('#target').css('background-color','blue')
                    .css('color','white').html('��ǥ����');
                	console.log('else����');
                }
            }
        });
    });
});
*/

$(function(){
	$('#chk').click(function(){
		
		let sccode = ${vo.num};
	     let scid = "${sessionScope.sessionID}";
		 
	     let param = {"sccode":sccode, "scid":scid}
		
	     console.log(sccode);
	     console.log(scid);
	     console.log(param);
	     
	     $.ajax({
	    	 anyne:true,
	    	 type:'POST',
	    	 data:JSON.stringify(param),
	    	 url:"../surveycheck",
	    	 dataType :"text",
	    	 
	    	 success:function(data){
	    		 alert("�Ƴ�?!");
	    		 location.href="/surveylist";
	    	 },
	     	
	     });
	});
});


</script>