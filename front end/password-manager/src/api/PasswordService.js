import axios from 'axios';

export class PasswordService{
    async authenticateUser(password) {
        const response = await axios.post(`http://localhost:8080/api/pass/login/${password}`);
        return response;
    }

    async getAllPasswords() {
      const response = await axios.get('http://localhost:8080/api/pass', {

      });
      return response;
    }

    async addPassword(body) {
      const response = await axios.post('http://localhost:8080/api/pass', {
          
      });
      return response;
    }

    async editPassword(body) {
      const response = await axios.put('http://localhost:8080/api/pass', edits, {
        headers: {
          Authorization: `Bearer ${token}`
        },

      });
      return response;
    }

    async deletePassword(passwordId) {
      const response = await axios.delete('http://localhost:8080/' + passwordId, {

      });
      return response;
    }
}
