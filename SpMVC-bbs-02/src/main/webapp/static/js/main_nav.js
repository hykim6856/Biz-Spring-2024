// main-nav 각 tag className 을 키로하는 객체 선언
const NAV_INDEX = {
  home: { url: "/" },
  notice: { url: "/bbs/notice" },
  bbs: { url: "/bbs/free" },
};
document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItems = mainNav.querySelectorAll("li");

  mainNav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      // 모든 nav.main 의 li tag 에 active 라는 이름의 class제거하기
      navItems.forEach((item) => {
        item.classList.remove("active");
      });
      // 클릭된 항목에 active 라는 클래스를 추가하기
      target.classList.add("active");
      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      // alert(url);
      document.location.href = `${rootPath}${url}`;
    }
  });
});
