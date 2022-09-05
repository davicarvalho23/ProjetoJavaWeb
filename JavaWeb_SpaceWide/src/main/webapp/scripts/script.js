var ctx = document.getElementById("myChart");

var stars = [135850, 52122];
var tipos = ["Ativo", "Inativo"];

var myChart = new Chart(ctx, {
  type: "bar",
  data: {
    labels: tipos,
    datasets: [
      {
        label: "Cliente",
        data: stars,
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(54, 162, 235, 0.2)",
        ]
      }
    ]
  }
});