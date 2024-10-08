let checkId = "0";

window.addEventListener("load", function () {
  check_id();
  check_password();
});


let check_password = function(){
let input_pw = document.querySelector('#input_pw');
let pw_check = document.querySelector('#pw_check');
let pw_info = document.querySelector('#pw_info');

pw_check.addEventListener('keyup',function(){
  if(input_pw.value != pw_check.value) {
  pw_info.innerHTML='비밀번호가 다릅니다.'
} else if (input_pw.value == pw_check.value) {
  pw_info.innerHTML='비밀번호 체크!'  
  }

})
}

let fn_validation = function () {
  let input_id = document.querySelector("#input_id");
  let input_name = document.querySelector("#input_name");
  let input_pw = document.querySelector("#input_pw");

  let regexp_pw = /^(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;

  if (input_id.value == "") {
    alert("아이디를 입력하세요.");
    return;
  } else if (input_name.value == "") {
    alert("이름을 입력하세요.");
    return;
  } else if (input_pw.value == "") {
    alert("비밀번호를 입력하세요.");
    return;
  } else if (!regexp_pw.test(input_pw.value)){
    alert("비밀번호는 영문자, 숫자와 특수문자를 조합하여주세요 \n 8~12자리를 입력하세요.");
    return;
  } else {
    registerForm.submit();
  }

};

let check_id = function () {
  let btn_checkId = document.querySelector("#btn_checkId");
  
  let regExp_id = /^[a-zA-Z0-9]{4,12}$/;
  
  btn_checkId.addEventListener("click", function () {
    let inputIdValue = document.querySelector("#input_id").value;

    if (inputIdValue == "") {
      alert("아이디를 입력해주세요.");
      return;
    } else if (!regExp_id.test(inputIdValue)) {
      alert(
        "아이디는 영문자(대,소문자)와 숫자만 입력가능합니다.\n 4~12자리를 입력하세요."
      );
    } else {
      fetch(`/checkId/${inputIdValue}`)
        .then(res => res.json())
        .then(data => {
          if (data.id_res == "1") {
            alert("중복된 아이디입니다.");
          } else {
            checkId.value = "1";
            alert("사용가능한 아이디입니다.");
          }
        });
    }
  });
};
