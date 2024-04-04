document.addEventListener("DOMContentLoaded", () => {
  const iolist_body = document.querySelector("table.iolist tbody");
  iolist_body.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const seq = target.closest("TR").dataset.seq;
      //   alert(seq);
      document.location.href = `${rootPath}/iolist/detail/${seq}`;
    }
  });
});
