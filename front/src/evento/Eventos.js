function Eventos ({botao, eventoTeclado, criar, objetoEvento, cancelar, remover, alterar}) {
    return (
        <form>
            <input type="text" value={objetoEvento.nome_evento} onChange={eventoTeclado} name='nome_evento' placeholder="Nome do Evento" className="form-control"/>
            <input type="textarea" value={objetoEvento.descricao_evento} onChange={eventoTeclado} name='descricao_evento' placeholder="Descrição do Evento" className="form-control"/>
            <input type="text" value={objetoEvento.data_evento} onChange={eventoTeclado} name='data_evento' placeholder="Data do Evento" className="form-control"/>
            <input type="text" value={objetoEvento.horario_evento} onChange={eventoTeclado} name='horario_evento' placeholder="Horario do Evvento" className="form-control"/>
            <input type="text" value={objetoEvento.duracao_evento} onChange={eventoTeclado} name='duracao_evento' placeholder="Duração do Evento" className="form-control"/>

            {
                botao 
                ?
                <input type="button" value='Cadastrar' onClick={criar} className="btn btn-primary"/>
                :
                <div>
                    <input type="button" value='Alterar' onClick={alterar} className="btn btn-warning"/>
                    <input type="button" value='Remover' onClick={remover} className="btn btn-danger"/>
                    <input type="button" onClick={cancelar} value='Cancelar' className="btn btn-secondary"/>
                </div> 
            }
            
            
        </form>
    )
}

export default Eventos;