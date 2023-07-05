import { useEffect, useState } from 'react';
import './App.css';
import Eventos from './evento/Eventos';
import TabelaEventos from './evento/TabelaEventos';

function App() {

  //Objeto Evento
  const evento = {
    id_evento: 0,
    data_evento: '',
    descricao_evento: '',
    horario_evento: '',
    duracao_evento: '',
    nome_evento: '',
    administrador_id_adm: {
      id_adm: 1,
      usuario_id_usuario: {
        id_usuario: 1
      }
    }
  }


  //useState
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [eventos, setEventos] = useState([]);
  const [objEvento, setObjEvento] = useState(evento);

  //useEffect
  useEffect(()=>{
    fetch("http://localhost:8080/evento/listar")
    .then(retorno => retorno.json())
    .then(retorno_convertido => setEventos(retorno_convertido))
  }, []);


  //Obtendo os dados do formulário
  const aoDigitar = (e) => {
    setObjEvento({...objEvento, [e.target.name]:e.target.value});
  }

  //Cadastrar Evento
  const criar = () => {
    fetch('http://localhost:8080/evento/criar', {
      method:'post',
      body: JSON.stringify(objEvento),
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      if(retorno_convertido.mensagem !== undefined) {
        alert("Campo obrigatório não preenchido!");
      }else {
        setEventos([...eventos, retorno_convertido]);
        alert("Evento registrado com sucesso!")
        limparFormulario();
      }
    })
  }

    //Alterar Evento
    const alterar = () => {
      fetch('http://localhost:8080/evento/alterar', {
        method:'put',
        body: JSON.stringify(objEvento),
        headers:{
          'Content-type':'application/json',
          'Accept':'application/json'
        }
      })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {

        if(retorno_convertido.mensagem !== undefined) {
          alert("Campo obrigatório não preenchido!");
        }else {
          
          //Mensagem
          alert("Evento alterado com sucesso!")

          //Copia do vetor de Eventos
          let vetorTemp = [...eventos];

          //Indice
          let indice = vetorTemp.findIndex((e) => {
            return e.id_evento === objEvento.id_evento;
          });

          // Alterar evento do vetorTemp
          vetorTemp[indice] = objEvento;

          //Atualizar o vetor de Eventos
          setEventos(vetorTemp);

          //limpar formulario
          limparFormulario();
        }
      })
    }


  //Remover Evento
  const remover = () => {
    fetch('http://localhost:8080/evento/remover/'+objEvento.id_evento, {
      method:'delete',
      headers:{
        'Content-type':'application/json',
        'Accept':'application/json'
      }
    })
    .then(retorno => retorno.json())
    .then(retorno_convertido => {
      
      //Mensagem
      alert(retorno_convertido.mensagem);

      //Copia do vetor de Eventos
      let vetorTemp = [...eventos];

      //Indice
      let indice = vetorTemp.findIndex((e) => {
        return e.id_evento === objEvento.id_evento;
      });

      // Remover evento do vetorTemp
      vetorTemp.splice(indice, 1);

      //Atualizar o vetor de Eventos
      setEventos(vetorTemp);

      // limpar formulario
      limparFormulario();

    })
  }


  //limpar formulário
  const limparFormulario = () => {
    setObjEvento(evento);
    setBtnCadastrar(true);
  }

  //Selecionar evento
  const selecionarEventos = (indice) => {
    setObjEvento(eventos[indice]);
    setBtnCadastrar(false);
  }

  //Retorno
  return (
    <div >
      <Eventos botao={btnCadastrar} eventoTeclado={aoDigitar} criar={criar} objetoEvento={objEvento} cancelar={limparFormulario} remover={remover} alterar={alterar} />
      <TabelaEventos vetor={eventos} selecionar={selecionarEventos}/>
    </div>
  );
}

export default App;
