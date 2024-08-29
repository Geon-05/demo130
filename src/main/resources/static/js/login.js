window.addEventListener("load", function () {
  loginEvent();
  go_register();
});

let loginEvent = function () {
  let btn_login = document.querySelector("#btn_login");
  let id = document.querySelector("#input_id");
  let pw = document.querySelector("#input_password");

  btn_login.addEventListener("click", function () {
    if (id.value == "") {
      alert("아이디를 입력하세요.");
      return;
    } else if (pw.value == "") {
      alert("비밀번호를 입력하세요.");
      return;
    } else {
      alert("로그인 성공!");
      form_login.submit();
    }
  });
};

let go_register = function () {
  let btn_regist = document.querySelector("#btn_regist");

  btn_regist.addEventListener("click", function () {
    location.href = "/login/register";
  });
};
