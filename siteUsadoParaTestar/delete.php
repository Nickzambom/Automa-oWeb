<?php
include 'db.php';

$id = $_GET['id']; // Pegar o ID do usuário a ser deletado

$sql = "DELETE FROM users WHERE id=?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $id);

if ($stmt->execute()) {
    header("Location: success.php");
    exit;
} else {
    echo "Erro ao deletar registro: " . $stmt->error;
}

$conn->close();
?>
