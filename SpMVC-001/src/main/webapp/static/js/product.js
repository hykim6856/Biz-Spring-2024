document.addEventListener("DOMContentLoaded", () => {
  const product_body = document.querySelector("tbody.product_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const product_body_onClick_handler = (e) => {
    const target = e.target;
    if ((target.tagName = "TD")) {
      const TR = target.closest("TR");
      const pcode = TR.dataset.pcode;
      alert(pcode);
      document.location.href = `${rootPath}/product/detail?p_code=${pcode}`;
    }
  };

  product_body?.addEventListener(
    "click",
    product_body_onClick_handler
  );
  btn_update.addEventListener("click", (e) => {
    const pcode = e.target.dataset.pcode;
    alert(pcode);
    document.location.href = `${rootPath}/product/update?pcode=${pcode}`;
  });

  btn_delete.addEventListener("click", (e) => {
    const pcode = e.target.dataset.pcode;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(
        `${rootPath}/product/delete/${pcode}`
      );
    }
  });
});
