<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Visualizar Usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: #cccccc;background-image: radial-gradient(black, gray);";>
    <div class="container-md" style="width: 100%; height:70%; background-image: radial-gradient(#f0f0f0, gray); border-radius: 2%;margin-top:10px;padding-top:3px;padding-bottom:0px;">
    <h1><span class="badge text-bg-dark">Lista de Usuários</span></h1>
        <div class="mx-auto p-3" style="width: 100%;">
        <?php
        include 'db.php';

        $sql = "SELECT id, Nome, Sobrenome, Idade, Telefone, Email, Linkedin FROM users";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {//percorre as colunas e linhas e nos apresenta os dados dos usuários cadastrados
            while($row = $result->fetch_assoc()) {
                echo "<ul class='list-group' style=margin-bottom:18px >
                <li class='list-group-item active' aria-current='true'>ID: " . $row["id"] . " </li>
                <li class='list-group-item'>Nome: " . $row["Nome"] . " " . $row["Sobrenome"] . "</li>
                <li class='list-group-item'>Idade: " . $row["Idade"] . "</li>
                <li class='list-group-item'>Telefone: " . $row["Telefone"] . "</li>
                <li class='list-group-item'>Email: <a href='mailto:" . $row["Email"] . "'>" . $row["Email"] . "</li>
                <li class='list-group-item'><a href='". $row["Linkedin"] . "' target='_blank'>" . $row["Linkedin"] . "</li>
                <li class='list-group-item'><a style='width:7%;margin-right:10px; margin-top:0;' href='edit.php?id=" . $row['id'] . "'class='btn btn-primary'>Editar</a><a style='width:7%;' href='delete.php?id=" . $row['id'] . "' onclick='return confirm(\"Tem certeza que deseja deletar este usuário?\");'class='btn btn-primary'>Deletar</a></li>
                </ul>";
            }
        } else {
            //caso não tenha usuários cadastrados
            echo "<p style='margin-top:22px;margin-bottom:4px' class='fw-medium'>0 Usuários encontrados</p>";
        }
        //botão de cadastrar definitivo
        echo "<br><br><br><a href='index.html'class='btn btn-primary'>Cadastrar</a>";
        $conn->close();
        ?>
        </div>
    </div>
    <!-- Scripts e estilos adicionais -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

