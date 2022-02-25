let index={
    init: function () {
        $("#btn-save").on("click", () =>{ /*.on("click",여기 엔 이러나는 이벤트*/
            this.save();
        });
    },
     //위의 세이브 버튼을 클릭하면 밑의 세이브함수가 호출된다
     save: function (){
         alert('user의 save함수 호출됨');
     }
}

index.init();