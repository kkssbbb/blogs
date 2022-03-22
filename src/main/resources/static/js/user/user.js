
let index={
    init: function () {
        $("#btn-save").on("click", () =>{ /*.on("click",여기 엔 이러나는 이벤트*/
            this.save();
        });
        $("#btn-update").on("click", () =>{ /*.on("click",여기 엔 이러나는 이벤트*/
            this.save();
        });

    },
     //위의 세이브 버튼을 클릭하면 밑의 세이브함수가 호출된다
     save: function () {
         //alert('user의 save함수 호출됨');
         let data = {
             username: $("#username").val(),
             password: $("#password").val(),
             email: $("#email").val()
         };
         //console.log(data);
         //ajax호출시 difault가 비동기 호출
         //ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청
         $.ajax({
             //회원가입 수행 요청
             type: "POST",
             url: "/auth/joinProc",
             data: JSON.stringify(data), //http body데이터
             contentType: "application/json; charset-utf-8", //body데이터가 어떤 타입인지(MIME)
             // dataType: "text" //요청을 서버로해서 응답이 왔을 때 기본적으로는 거의다 문자열이고 생긴게 json이라면 => javascript로 변경해준다.
               // dataType 이 디폴트가 json 인거같다.
         }).done(function (resp) {
             alert("회원가입이 완료되었습니다.");
             console.log(resp);
             location.href = "/";
         }).fail(function (error){
             alert(JSON.stringify(error));
      });
     },

    update: function () {
        //alert('user의 save함수 호출됨');
        let data = {
            id:$("#id").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };
        $.ajax({
            //회원가입 수행 요청
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data), //http body데이터
            contentType: "application/json; charset-utf-8", //body데이터가 어떤 타입인지(MIME)
            // dataType: "text" //요청을 서버로해서 응답이 왔을 때 기본적으로는 거의다 문자열이고 생긴게 json이라면 => javascript로 변경해준다.
            // dataType 이 디폴트가 json 인거같다.
        }).done(function (resp) {
            alert("회원수정이 완료되었습니다.");
            console.log(resp);
            location.href = "/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },


}
//회원 가입시 Ajax를 사용하는 2가지 이유
//1. 요청에 대한 응답을 html 이 아닌 Data(json)을 받기위해서
index.init();