document.addEventListener("DOMContentLoaded", () => {
  const iolist_body = document.querySelector("tbody.iolist_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const iolist_body_onClick_handler = (e) => {
    const target = e.target;
    if ((target.tagName = "TD")) {
      const TR = target.closest("TR");
      const seq = TR.dataset.seq;
      alert(seq);
      document.location.href = `${rootPath}/detail?io_seq=${seq}`;
    }
  };

  iolist_body?.addEventListener("click", iolist_body_onClick_handler);
  btn_update.addEventListener("click", (e) => {
    const seq = e.target.dataset.seq;
    // alert(seq);
    document.location.href = `${rootPath}/update?io_seq=${seq}`;
  });

  btn_delete.addEventListener("click", (e) => {
    const seq = e.target.dataset.seq;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/delete/${seq}`);
    }
  });
});
