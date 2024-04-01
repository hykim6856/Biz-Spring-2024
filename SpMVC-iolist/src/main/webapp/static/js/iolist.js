document.addEventListener("DOMContentLoaded", () => {
  const iolist_body = document.querySelector("tbody.iolist_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const iolist_body_onClick_handler = (e) => {
    const target = e.target;
    if ((target.tagName = "TD")) {
      const TR = target.closest("TR");
      const io_seq = TR.dataset.io_seq;
      alert(io_seq);
      document.location.href = `${rootPath}/detail?io_seq=${io_seq}`;
    }
  };

  iolist_body?.addEventListener("click", iolist_body_onClick_handler);
  btn_update.addEventListener("click", (e) => {
    const io_seq = e.target.dataset.io_seq;
    // alert(io_seq);
    document.location.href = `${rootPath}/update?io_seq=${io_seq}`;
  });

  btn_delete.addEventListener("click", (e) => {
    const io_seq = e.target.dataset.io_seq;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(`${rootPath}/delete/${io_seq}`);
    }
  });
});
