let index={
    init: function () {
        $("#btn-save").on("click", () =>{ /*.on("click",여기 엔 이러나는 이벤트*/
            this.save();
        });
    },
     //위의 세이브 버튼을 클릭하면 밑의 세이브함수가 호출된다
     save: function (){
         //alert('user의 save함수 호출됨');
         let data ={
             username: $("#username").val(),
             password: $("#password").val(),
             email: $("#email").val()
         }
         //console.log(data);
         $.ajax().done().fail(); //ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
     }
}
//회원 가입시 Ajax를 사용하는 2가지 이유
//1. 요청에 대한 응답을 html 이 아닌 Data(json)을 받기위해서
index.init();