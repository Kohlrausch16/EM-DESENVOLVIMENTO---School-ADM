import { useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import img from '/assets/images/logo.png';
import { Card, Logo, CardText, TextArea, Input, ActionButton } from './LoginCardStyle';
import { login } from '../axios';

const LoginCard = () => {

  const emailContent = useRef<HTMLInputElement | null>(null);
  const passwordContent = useRef<HTMLInputElement | null>(null);
  const navigate = useNavigate(); 

  document.addEventListener('keydown', (evento) => {
    if (evento.key === 'Enter') {
      submit('/home'); 
    }
  });

  function submit(link: string) {
    const emailValue = emailContent.current ? emailContent.current.value : '';
    const passwordValue = passwordContent.current ? passwordContent.current.value : '';

    if (emailValue === '' || passwordValue === '') {
      alert('Email e/ou senha não informados!');
    } else {
      let loginAccepted = false;

      for (let i = 0; i <= login.length - 1; i++) {
        if (emailValue === login[i].email && passwordValue === login[i].password) {
          loginAccepted = true;
          break;
        }
      }

      if (loginAccepted === true) {
        navigate(link);
      } else {
        alert('Acesso negado!');
      }
    }
  }

  return (
    <Card>
      <Logo src={img} />
      <CardText>Realize seu login</CardText>
      <TextArea>
        <Input id="emailInput" ref={emailContent} type="email" placeholder="Informe seu e-mail" />
      </TextArea>
      <TextArea>
        <Input id="passwordInput" ref={passwordContent} type="password" placeholder="Informe sua senha" />
      </TextArea>
      <ActionButton id="button" onClick={() => submit('/home')}>Entrar</ActionButton>
    </Card>
  );
};

export default LoginCard;