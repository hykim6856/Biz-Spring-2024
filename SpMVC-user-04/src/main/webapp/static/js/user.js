document.addEventListener("DOMContentLoaded", () => {
  const join_form = document.querySelector("form.join");
  const username = join_form.querySelector("input[name='u_name']");
  const password = join_form.querySelector(
    "input[name='u_password']"
  );
  const re_password = join_form.querySelector(
    "input[name='re_password']"
  );
  const btn_join = join_form.querySelector("button");

  btn_join.addEventListener("click", () => {
    if (!username.value) {
      alert("username은 반드시 입력하세요");
      username.select();
      return false;
    }
    if (!password.value) {
      alert("password는 반드시 입력하세요");
      password.select();
      return false;
    }
    if (!re_password.value) {
      alert("re_password 반드시 입력하세요");
      re_password.select();
      return false;
    }
    if (password.value !== re_password.value) {
      alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
      password.select();
      return false;
    }
    join_form.submit();
  });
});
