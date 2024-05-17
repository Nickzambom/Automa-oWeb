<?php
include 'db.php';

$id = $_GET['id']; // Pegar o ID do usuário a ser editado

$sql = "SELECT * FROM users WHERE id = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id);
$stmt->execute();
$result = $stmt->get_result();

if ($row = $result->fetch_assoc()) {
    ?>
    <body style="background-color: #cccccc;background-image: radial-gradient(black, gray);";>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <div class="container-md" style="width: 100%; height:70%; background-image: radial-gradient(#f0f0f0, gray); border-radius: 2%;margin-top:10px;padding-top:3px;padding-bottom:0px;">
        <h1><span class="badge text-bg-dark">Editar Usuário</span></h1>
        <div class="mx-auto p-3" style="width: 100%;">
            <form action="update.php" method="post">
                <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
                <div class="mb-3">
                    <label class="form-label">Nome</label>
                    <input class="form-control" type="text" name="Nome" value="<?php echo $row['Nome']; ?>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Sobrenome</label>
                    <input class="form-control" type="text" name="Sobrenome" value="<?php echo $row['Sobrenome']; ?>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Idade</label>
                    <input class="form-control" type="number" name="Idade" value="<?php echo $row['Idade']; ?>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Telefone</label>
                    <input class="form-control" type="number" name="Telefone" value="<?php echo $row['Telefone']; ?>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input class="form-control" type="email" name="Email" value="<?php echo $row['Email']; ?>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Linkedin</label>
                    <input class="form-control" type="url" name="Linkedin" value="<?php echo $row['Linkedin']; ?>">
                </div>
                <input type="submit"class="btn btn-primary" value="Atualizar">
            </form>
        </div>
    </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <?php
} else {
    echo "Usuário não encontrado.";
}
$conn->close();
?>
