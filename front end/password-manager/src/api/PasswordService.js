import axios from 'axios';

export class PasswordService{
    async authenticateUser(password) {
        const response = await axios.post('http://localhost:8080/login', { pass: password });
        return response;
    }

    async getAllPasswords() {
      const token = localStorage.getItem('authToken');

      const response = await axios.get('http://localhost:8080/login', {
        headers: {
          Authorization: `Bearer ${token}`
        },
      });
      return response;
    }

    async editPassword(edits) {
      const response = await axios.put('http://localhost:8080/', edits, {
        headers: {
          Authorization: `Bearer ${token}`
        },

      });
      return response;
    }

    async deletePassword(passwordId) {
      const response = await axios.delete('http://localhost:8080/' + passwordId, {
        headers: {
          Authorization: `Bearer ${token}`
        },
      });
      return response;
    }
}
