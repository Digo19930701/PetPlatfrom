import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/



export default defineConfig({

  devServer: {
    proxy: {
      '/4A2Bpet': {
        target: 'http://localhost:3300',
        changeOrigin: true
      }
    }
  },


  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }

})