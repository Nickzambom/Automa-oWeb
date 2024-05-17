<?php
include 'db.php';

$id = $_POST['id'];
$nome = $_POST['Nome'];
$sobrenome = $_POST['Sobrenome'];
$idade = $_POST['Idade'];
$telefone = $_POST['Telefone'];
$email = $_POST['Email'];
$linkedin = $_POST['Linkedin'];

$sql = "UPDATE users SET Nome=?, Sobrenome=?, Idade=?, Telefone=?, Email=?, Linkedin=? WHERE id=?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ssiissi", $nome, $sobrenome, $idade,$telefone, $email, $linkedin, $id);

if ($stmt->execute()) {
    // Redireciona para success.php após inserção bem-sucedida
    header("Location: success.php");
    exit;
} else {
    echo "Erro: " . $stmt->error;
}

$conn->close();
?>
