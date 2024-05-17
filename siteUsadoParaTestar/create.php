<?php
include 'db.php';

$nome = $_POST['Nome'];
$sobrenome = $_POST['Sobrenome'];
$idade = $_POST['Idade'];
$telefone = $_POST['Telefone'];
$email = $_POST['Email'];
$linkedin = $_POST['Linkedin'];

// Verifique se o e-mail ou telefone já existem
$checkSql = "SELECT * FROM users WHERE Email = ? OR Telefone = ?";
$checkStmt = $conn->prepare($checkSql);
$checkStmt->bind_param("ss", $email, $telefone);
$checkStmt->execute();
$checkResult = $checkStmt->get_result();

if ($checkResult->num_rows > 0) {
    // Se existir o email ou telefone cadastrado, lança um ALERT
    echo "<script>alert('Já existe um cadastro com este e-mail ou telefone.'); window.history.back();</script>";
} elseif ($idade <= 0 || empty($nome) || empty($sobrenome) || empty($idade) || empty($telefone) || empty($email) || empty($linkedin)) {
    echo "<script>alert('Dados inválidos (VERIFIQUE OS CAMPOS)'); window.history.back();</script>";
} else {
    $sql = "INSERT INTO users (Nome, Sobrenome, Idade, Telefone, Email, Linkedin) VALUES (?, ?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssiiss", $nome, $sobrenome, $idade, $telefone, $email, $linkedin);

    if ($stmt->execute()) {
        // Redireciona para success.php após inserção bem-sucedida
        header("Location: success.php");
        exit;
    } else {
        echo "Erro: " . $stmt->error;
    }
}

$conn->close();
?>
