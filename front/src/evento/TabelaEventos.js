function TabelaEventos ({vetor, selecionar}) {
    return (
        <table className="table">
            <thead>
                <tr>
                    <td>#</td>
                    <td>Nome</td>
                    <td>Descrição</td>
                    <td>Data</td>
                    <td>Horario</td>
                    <td>Duração</td>
                    <td>Selecionar</td>
                </tr>
            </thead>

            <tbody>
                {
                    vetor.map((obj, indice) => (
                     <tr key={indice}>
                        <td>{indice+1}</td>
                        <td>{obj.nome_evento}</td>
                        <td>{obj.descricao_evento}</td>
                        <td>{obj.data_evento}</td>
                        <td>{obj.horario_evento}</td>
                        <td>{obj.duracao_evento}</td>
                        <td><button onClick={() => {selecionar(indice)}} className="btn btn-success">Selecionar</button></td>
                     </tr>
                    ))
                }
            </tbody>
        </table>
    )
}

export default TabelaEventos;