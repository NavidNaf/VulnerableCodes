from Crypto.Cipher import AES
import os

# Vulnerable cryptographic implementation
def encrypt_message(message):
    key = b'Sixteen byte key'  # Hardcoded key (not secure)
    cipher = AES.new(key, AES.MODE_EAX)
    ciphertext, tag = cipher.encrypt_and_digest(message.encode())
    return ciphertext

def decrypt_message(ciphertext):
    key = b'Sixteen byte key'  # Hardcoded key (not secure)
    cipher = AES.new(key, AES.MODE_EAX)
    plaintext = cipher.decrypt(ciphertext)
    return plaintext.decode()